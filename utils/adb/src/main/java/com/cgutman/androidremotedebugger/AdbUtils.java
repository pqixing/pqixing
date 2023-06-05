package com.cgutman.androidremotedebugger;

import com.cgutman.adblib.AdbCrypto;
import com.cgutman.androidremotedebugger.adblib.AndroidBase64;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public class AdbUtils {

    public static final String PUBLIC_KEY_NAME = "public.key";
    public static final String PRIVATE_KEY_NAME = "private.key";

    public static AdbCrypto readCryptoConfig(File dataDir) {
        File pubKey = new File(dataDir, PUBLIC_KEY_NAME);
        File privKey = new File(dataDir, PRIVATE_KEY_NAME);

        AdbCrypto crypto = null;
        if (pubKey.exists() && privKey.exists()) {
            try {
                crypto = AdbCrypto.loadAdbKeyPair(new AndroidBase64(), privKey, pubKey);
            } catch (Exception e) {
                crypto = null;
            }
        }

        return crypto;
    }

    public static AdbCrypto writeNewCryptoConfig(File dataDir) {
        File pubKey = new File(dataDir, PUBLIC_KEY_NAME);
        File privKey = new File(dataDir, PRIVATE_KEY_NAME);

        AdbCrypto crypto = null;

        try {
            crypto = AdbCrypto.generateAdbKeyPair(new AndroidBase64());
            crypto.saveAdbKeyPair(privKey, pubKey);
        } catch (Exception e) {
            crypto = null;
        }

        return crypto;
    }

    public static void updateCryptoIfNeed(File dataDir) {
        if (readCryptoConfig(dataDir) == null) {
            new Thread(() -> writeNewCryptoConfig(dataDir)).start();
        }
    }

    public static boolean safeClose(Closeable c) {
        if (c == null)
            return false;

        try {
            c.close();
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public static void safeAsyncClose(final Closeable c) {
        if (c == null)
            return;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.close();
                } catch (IOException ignored) {
                }
            }
        }).start();
    }
}
