package com.microblink.blinkid.util;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;

import com.microblink.blinkid.libutils.R;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtils {

    public static byte[] loadBytesFromFileUri(Uri fileUri, Context context) {
        InputStream fileStream = null;
        try {
            fileStream = context.getContentResolver().openInputStream(fileUri);
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            byte[] bytes = new byte[fileStream.available()];
            int nRead;
            while ((nRead = fileStream.read(bytes, 0, bytes.length)) != -1) {
                buffer.write(bytes, 0, nRead);
            }
            return buffer.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(context, R.string.toast_error_open_file, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, R.string.toast_error_read_file, Toast.LENGTH_SHORT).show();
        } finally {
            try {
                fileStream.close();
            } catch (IOException e) {
                //can be ignored
            }
        }

        return null;
    }

    public static String loadStringFromFileUri(Uri fileUri, Context context) {
        InputStream fileStream = null;
        try {
            if (fileUri != null) {
                fileStream = context.getContentResolver().openInputStream(fileUri);
                return convertStreamToString(fileStream);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(context, R.string.toast_error_open_file, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, R.string.toast_error_read_file, Toast.LENGTH_SHORT).show();
        } finally {
            try {
                fileStream.close();
            } catch (IOException e) {
                //can be ignored
            }
        }

        return null;
    }

    public static String convertStreamToString(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }

}
