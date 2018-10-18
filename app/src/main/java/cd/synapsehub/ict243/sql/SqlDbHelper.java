package cd.synapsehub.ict243.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import cd.synapsehub.ict243.model.Member;
import cd.synapsehub.ict243.utils.Constants;

public class SqlDbHelper extends SQLiteOpenHelper{


    private static final int DATABASE_VERSION=1;

    public SqlDbHelper(Context context) {
        super(context, Constants.DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(Constants.DROP_USER_TABLE);
        onCreate(db);
    }

    public void addMember(Member member){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Constants.COLUMN_MEMBER_NAME,member.getName());
        values.put(Constants.COLUMN_MEMBER_EMAIL,member.getEmail());
        values.put(Constants.COLUMN_MEMBER_PASSWORD,member.getPassword());

        db.insert(Constants.TABLE_MEMBER, null,values);
        db.close();
    }

    public boolean checkUser(String email){
        String[] columns = {
                Constants.COLUMN_MEMBER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = Constants.COLUMN_MEMBER_EMAIL + " = ?";
        String[] selectionArgs = { email };

        Cursor cursor = db.query(Constants.TABLE_MEMBER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){
            return true;
        }
        return false;
    }

    public boolean checkUser(String email, String password){
        String[] columns = {
                Constants.COLUMN_MEMBER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = Constants.COLUMN_MEMBER_EMAIL + " = ?" + " AND " + Constants.COLUMN_MEMBER_PASSWORD + " =?";
        String[] selectionArgs = { email, password };

        Cursor cursor = db.query(Constants.TABLE_MEMBER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){
            return true;
        }
        return false;
    }


}
