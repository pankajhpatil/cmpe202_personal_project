package com.cmpe202.ip1;

public class FileParserFactory {
	private InputFileParser fp = null;

	public InputFileParser getFp() {
		return fp;
	}

	public void setFp(InputFileParser fp) {
		this.fp = fp;
	}

	public InputFileParser getFileParser(String fileType) {
		if (fileType == null) {
			return null;
		}

		if ("CSV".equalsIgnoreCase(fileType)) {
			setFp(new CSVFileParser());
		}else if ("JSON".equalsIgnoreCase(fileType)) {
			setFp(new JSONFileParser());
		}else if ("XML".equalsIgnoreCase(fileType)) {
			setFp(new XMLFileParser());
		}
		return getFp();
	}

}
