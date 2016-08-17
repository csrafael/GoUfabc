package android.ufabc.edu.br.goufabc;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dellacroix on 17/08/16.
 */
public class Matrix {

    public static String[][] readFromAssets(Context context, String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(filename)));

        String line = null;
        int index = 0;
        String [][] matrix = new String [151][5];

        while ((line = reader.readLine()) != null) {
            if (index < matrix.length) matrix[index] = line.split(" ");
            index++;
        }

        reader.close();
        return matrix;
    }

}
