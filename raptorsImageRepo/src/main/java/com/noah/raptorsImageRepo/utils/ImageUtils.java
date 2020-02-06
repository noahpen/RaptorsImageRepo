package com.noah.raptorsImageRepo.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageUtils {

	public static String getAbsolutePath() {
		// Current path
		Path currPath = Paths.get(".");
		// Absolute path
		Path absPath = currPath.toAbsolutePath();
		String photosDir = absPath + "/src/main/resources/static/photos/";
		return photosDir;
	}
	
}
