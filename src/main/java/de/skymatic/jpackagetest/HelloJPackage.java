package de.skymatic.jpackagetest;

import java.io.IOException;

/**
 * Hello world!
 */
public class HelloJPackage {

	private static final String greetings = "Hello JPackage!";

	public static void main(String[] args) {
		try {
			Process terminalProcess = openConsole();
			System.out.println(greetings);
			terminalProcess.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//TODO: this only works for windows. Linux and Mac support needs to be added
	private static Process openConsole() throws IOException {
		return new ProcessBuilder("cmd", "/c", "start", greetings).inheritIO().start();
	}
}
