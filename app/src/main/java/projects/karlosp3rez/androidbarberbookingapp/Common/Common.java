package projects.karlosp3rez.androidbarberbookingapp.Common;

import projects.karlosp3rez.androidbarberbookingapp.Model.Barber;
import projects.karlosp3rez.androidbarberbookingapp.Model.Salon;
import projects.karlosp3rez.androidbarberbookingapp.Model.User;

public class Common {
    public static final String KEY_ENABLE_BUTTON_TEXT = "ENABLE_BUTTON_TEXT";
    public static final String KEY_SALON_STORE = "SALON_SAVE";
    public static final String KEY_BARBER_LOAD_DONE = "BARBER_LOAD_DONE";
    public static final String KEY_DISPLAY_TIME_SLOT = "DISPLAY_TIME_SLOT";
    public static final String KEY_STEP = "STEP";
    public static final String KEY_BARBER_SELECTED = "BARBER_SELECT";
    public static String IS_LOGIN = "IsLogin";
    public static User currentUser;
    public static Salon currentSalon;
    public static int step = 0;
    public static String city = "";
    public static Barber currentBarber;
}
