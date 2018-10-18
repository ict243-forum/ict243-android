package cd.synapsehub.ict243.utils;

public class Constants {

    public static String KEY_EMAIL="email";
    public static String KEY_PASSWORD="password";

    //SQLite Database
    public static final String DATABASE_NAME = "MemberManager.db";
    public static final String TABLE_MEMBER = "member";
    public static final String COLUMN_MEMBER_ID = "member_id";
    public static final String COLUMN_MEMBER_NAME = "member_name";
    public static final String COLUMN_MEMBER_EMAIL = "member_email";
    public static final String COLUMN_MEMBER_PASSWORD = "member_password";

    public static String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_MEMBER + "("
            + COLUMN_MEMBER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_MEMBER_NAME + " TEXT,"
            + COLUMN_MEMBER_EMAIL + " TEXT," + COLUMN_MEMBER_PASSWORD + " TEXT" + ")";

    public static String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_MEMBER;


}
