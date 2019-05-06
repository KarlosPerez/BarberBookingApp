package projects.karlosp3rez.androidbarberbookingapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Salon implements Parcelable {
    private String name, address, website, openHours, phone, salonId;

    public Salon() {
    }

    public Salon(String name, String address, String website, String openHours, String phone, String salonId) {
        this.name = name;
        this.address = address;
        this.website = website;
        this.openHours = openHours;
        this.phone = phone;
        this.salonId = salonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalonId() {
        return salonId;
    }

    public void setSalonId(String salonId) {
        this.salonId = salonId;
    }

    public static Creator<Salon> getCREATOR() {
        return CREATOR;
    }

    protected Salon(Parcel in) {
        name = in.readString();
        address = in.readString();
        website = in.readString();
        openHours = in.readString();
        phone = in.readString();
        salonId = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(website);
        dest.writeString(openHours);
        dest.writeString(phone);
        dest.writeString(salonId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Salon> CREATOR = new Creator<Salon>() {
        @Override
        public Salon createFromParcel(Parcel in) {
            return new Salon(in);
        }

        @Override
        public Salon[] newArray(int size) {
            return new Salon[size];
        }
    };
}
