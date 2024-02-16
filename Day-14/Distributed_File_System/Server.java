package Distributed_File_System;

import java.util.ArrayList;
import java.util.Objects;

class Server {

    private int serverId;
    private int serverSize;
    ArrayList<File> file = new ArrayList<>();

    public Server(int serverId, int serverSize) {

        this.serverId = serverId;
        this.serverSize = serverSize;

    }


    public void uploadFile(File file1) throws DFSException {
        if (calculateFreeSpace() < file1.getFileSize()) {
            throw new DFSException("Insufficient space on the server");
        }

        file.add(file1);
        serverSize -= file1.getFileSize();

    }

    public boolean fileExists(String fileName) {
        for (File file : file) {
            if (Objects.equals(file.getFileName(), fileName)) {
                return true;
            }

        }
        return false;
    }

    public void downloadFile(String fileName) throws DFSException {
        for (File file : file) {
            if (Objects.equals(file.getFileName(), fileName)) {
                System.out.println(" File is Downloaded");
                return;
            }

        }
        System.out.println("Not downloaded");

    }

    public void replicateFile(File file, Server destinationServer) throws DFSException {
        System.out.println("File Replicated");
        destinationServer.uploadFile(file);

    }

    private int calculateFreeSpace() {
        int usedSpace = 0;
        for (File file : file) {
            usedSpace += file.getFileSize();
        }
        return serverSize - usedSpace;
    }
}
