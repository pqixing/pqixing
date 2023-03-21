package android.hardware.bydauto.multimedia;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class MediaInfo implements Parcelable {
    public static final Creator<MediaInfo> CREATOR = new a();
    public String albumName;
    public String artistName;
    public int duration;
    public String fileName;

    /* loaded from: classes.dex */
    static class a implements Creator<MediaInfo> {
        a() {
        }

        /* renamed from: a */
        public MediaInfo createFromParcel(Parcel parcel) {
            return new MediaInfo(parcel);
        }

        /* renamed from: b */
        public MediaInfo[] newArray(int i) {
            return new MediaInfo[i];
        }
    }

    public MediaInfo() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) obj;
        if (this.duration != mediaInfo.duration) {
            return false;
        }
        String str = this.fileName;
        if ((str == null && mediaInfo.fileName != null) || (str != null && !str.equals(mediaInfo.fileName))) {
            return false;
        }
        String str2 = this.artistName;
        if ((str2 == null && mediaInfo.artistName != null) || (str2 != null && !str2.equals(mediaInfo.artistName))) {
            return false;
        }
        String str3 = this.albumName;
        return (str3 != null || mediaInfo.albumName == null) && (str3 == null || str3.equals(mediaInfo.albumName));
    }

    public int hashCode() {
        int i = (527 + this.duration) * 31;
        String str = this.fileName;
        int i2 = 0;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.artistName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.albumName;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public void readFromParcel(Parcel parcel) {
        this.fileName = parcel.readString();
        this.artistName = parcel.readString();
        this.albumName = parcel.readString();
        this.duration = parcel.readInt();
    }

    public String toString() {
        return "fileName:{ " + this.fileName + " } artistName:{ " + this.artistName + " } albumName:{ " + this.albumName + " } duration:" + this.duration + " }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fileName);
        parcel.writeString(this.artistName);
        parcel.writeString(this.albumName);
        parcel.writeInt(this.duration);
    }

    protected MediaInfo(Parcel parcel) {
        readFromParcel(parcel);
    }
}
