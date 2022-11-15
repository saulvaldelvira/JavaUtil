/*
 * 
 * @author Saúl Valdelvira Iglesias
 * @version 14/04/2021
 *
 */
package saulv.util.file;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;






/**
 * A utility class to read/write text lines 
 * from/to a compressed text file (.txt.gz) 
 */
public class ZipFileUtil extends FileUtil {

	@Override 
	BufferedReader createReader(String inFileName) throws IOException  {
		 return new BufferedReader(
					new InputStreamReader(
							new GZIPInputStream(
									new FileInputStream(inFileName))));
	}
	
	@Override
	BufferedWriter createWriter(String outFileName) throws IOException {
		 return new BufferedWriter(
					new OutputStreamWriter(
							new GZIPOutputStream(
									new FileOutputStream(outFileName))));
	}
	
}
