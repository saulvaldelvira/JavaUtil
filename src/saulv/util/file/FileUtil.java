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
import java.io.IOException;
import java.util.List;

import saulv.collections.list.LinkedList;

public abstract class FileUtil {

	String filename;
	
	public FileUtil(String filename) {
		super();
		this.filename = filename;
	}

	public List<String> readLines() throws FileNotFoundException {
			List<String> res = new LinkedList<>();
			
			try {
				BufferedReader in = createReader(filename);
				
				try {
					while(in.ready()) {
						String line = in.readLine();
						res.add(line);
					}
				}finally {
					in.close();
				}
			}catch(FileNotFoundException e) {
				throw new FileNotFoundException("Archivo no encontrado");
			}catch (IOException e) {
				throw new RuntimeException("Error en lectura de datos");
			}
			
			return res;
		}

	abstract BufferedReader createReader(String inFileName) throws IOException;

	public void writeLine(String line) {
		try {
			BufferedWriter out = createWriter(filename);
			try {
				out.write(line);
				out.newLine();
			}finally {
				out.close();
			}
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void writeLines(List<String> lines) throws FileNotFoundException {
	
			try {
				BufferedWriter out = createWriter(filename);
				try {
					for(String line: lines) {
						out.write(line);
						out.newLine();
					}
				}finally {
					out.close();
				}
			}catch(IOException e) {
				throw new RuntimeException(e);
			}
			
	
		}

	abstract BufferedWriter createWriter(String inFileName) throws IOException;
	
}