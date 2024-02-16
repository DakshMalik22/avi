package Distributed_File_System;

import java.util.ArrayList;
import java.util.Objects;

class DFSSystem {
    ArrayList<Server> server = new ArrayList<>();
    ;

    public void addServer(Server server1) {
        server.add(server1);
        System.out.println("Server added successfully");
    }

    public void uploadFile(File file, Server server1) throws DFSException {
        if (server.contains(server1)) {
            server1.uploadFile(file);
        }
    }

    public void downloadFile(String fileName, Server server1) throws DFSException {
        for (Server server : server) {
            if (Objects.equals(server1, server)) {
                server1.downloadFile(fileName);
            }

        }

    }

    public void replicateFile(File file, Server sourceServer, Server destinationServer) throws DFSException {
        int flag = 0;
        boolean check1 = false;
        boolean check2 = false;
        for (Server server : server) {
            if (Objects.equals(sourceServer, server)) {
                check1 = true;
                boolean store = server.fileExists(file.getFileName());
                if (store == true) {

                    flag++;
                }
            }
            if (Objects.equals(destinationServer, server)) {
                check2 = true;
                flag++;

            }


        }
        if (!check1) {
            throw new DFSException("Source server does not exist");

        } else if (!check2) {
            throw new DFSException("Destination server does not exist");
        } else if (flag == 2) {
            destinationServer.replicateFile(file, destinationServer);
        } else {
            throw new DFSException("File does not exist");
        }


    }

}
