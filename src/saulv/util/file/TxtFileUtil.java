/*
 * 
 * @author Saúl Valdelvira Iglesias
 * @version 14/04/2021
 *
 */
package saulv.util.file;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



/**
 * A utility class to read/write text lines from/to a text file
 */
public class TxtFileUtil extends FileUtil {

	@Override
	BufferedReader createReader(String inFileName) throws FileNotFoundException {
		return new BufferedReader(new FileReader(inFileName));
	}

	@Override
	BufferedWriter createWriter(String outFileName) throws IOException {
		return new BufferedWriter(new FileWriter(outFileName));
	}

}
