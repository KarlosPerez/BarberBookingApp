package projects.karlosp3rez.androidbarberbookingapp.Model;

public class BookingInformation {
    private String customerName, customePhone, time, barberId, barberName, salonId, salonName, salonAddress;
    private Long slot;

    public BookingInformation(String customerName, String customePhone, String time, String barberId, String barberName, String salonId, String salonName, String salonAddress, Long slot) {
        this.customerName = customerName;
        this.customePhone = customePhone;
        this.time = time;
        this.barberId = barberId;
        this.barberName = barberName;
        this.salonId = salonId;
        this.salonName = salonName;
        this.salonAddress = salonAddress;
        this.slot = slot;
    }

    public BookingInformation() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomePhone() {
        return customePhone;
    }

    public void setCustomePhone(String customePhone) {
        this.customePhone = customePhone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBarberId() {
        return barberId;
    }

    public void setBarberId(String barberId) {
        this.barberId = barberId;
    }

    public String getBarberName() {
        return barberName;
    }

    public void setBarberName(String barberName) {
        this.barberName = barberName;
    }

    public String getSalonId() {
        return salonId;
    }

    public void setSalonId(String salonId) {
        this.salonId = salonId;
    }

    public String getSalonName() {
        return salonName;
    }

    public void setSalonName(String salonName) {
        this.salonName = salonName;
    }

    public String getSalonAddress() {
        return salonAddress;
    }

    public void setSalonAddress(String salonAddress) {
        this.salonAddress = salonAddress;
    }

    public Long getSlot() {
        return slot;
    }

    public void setSlot(Long slot) {
        this.slot = slot;
    }
}
