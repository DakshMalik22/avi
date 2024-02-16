package Distributed_File_System;

class File {
    private String fileName;
    private int fileSize;
    private boolean isReplicated;

    public File(String fileName, int fileSize, boolean isReplicated) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.isReplicated = isReplicated;
    }

    public int getFileSize() {
        return fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean isReplicated() {
        return isReplicated;
    }


}
