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

import saulv.collections.LinkedList;
import saulv.collections.List;

public abstract class FileUtil {

	public FileUtil() {
		super();
	}

	public List<String> readLines(String inFileName) throws FileNotFoundException {
			List<String> res = new LinkedList<>();
			
			try {
//				1-Crear el flujo de entrada (stream)
				BufferedReader in = createReader(inFileName);
				
//				2-Leer los datos	
				try {
					while(in.ready()) {
						String line = in.readLine();
						res.add(line);
					}
				}finally {
	//				3-Cerrar el flujo (aunque se produzca error)	
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

	public void writeLines(String outFileName, List<String> lines) throws FileNotFoundException {
	
			try {
	//			1-Crear flujo
				BufferedWriter out = createWriter(outFileName);
	//			2-Escribir
				try {
					for(String line: lines) {
						out.write(line);
						out.newLine();
					}
				}finally {
	//				3-Cerrar el flujo 
					out.close();
				}
			}catch(IOException e) {
				throw new RuntimeException(e);
			}
			
	
		}

	abstract BufferedWriter createWriter(String inFileName) throws IOException;
	
}