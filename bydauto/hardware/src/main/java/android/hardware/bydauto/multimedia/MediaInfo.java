//refactor
package android.hardware.bydauto.multimedia;
import android.os.Parcel;
import android.os.Parcelable;
public class MediaInfo implements Parcelable {
public static final Creator<MediaInfo> CREATOR = null;
public String albumName;
public String artistName;
public int duration;
public String fileName;
public MediaInfo createFromParcel(Parcel parcel) { return null; }
public MediaInfo[] newArray(int i) { return null; }
public final int describeContents() { return 0; }
public boolean equals(Object obj) { return false; }
public int hashCode() { return 0; }
public void readFromParcel(Parcel parcel) { }
public String toString() { return null; }
public void writeToParcel(Parcel parcel, int i) { }
 }
