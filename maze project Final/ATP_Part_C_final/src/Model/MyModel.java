package Model;

//import com.sun.org.apache.xpath.internal.operations.String;
import Client.Client;
import Client.IClientStrategy;
import IO.MyDecompressorInputStream;
import Server.*;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.AState;
import algorithms.search.MazeState;
import algorithms.search.Solution;
import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MyModel extends Observable implements IModel {
    private Solution solution;
    private ExecutorService threadPool = Executors.newCachedThreadPool();
    private Maze maze;

    private   Server generateServer;
    private   Server solveServer;
    public int characterPositionRow;
    public int characterPositionColumn;


//    private Position startPos ;
//    private Position endPos ;

    @Override
    public int getCharacterPositionRow() {
        return characterPositionRow;
    }

    @Override
    public int getCharacterPositionColumn() {
        return characterPositionColumn;
    }

    public MyModel() {
        generateServer = new Server(5400,1000,new ServerStrategyGenerateMaze());
        solveServer = new Server(5401,1000,new ServerStrategySolveSearchProblem());
        characterPositionRow=1;
        characterPositionColumn=1;

    }

    public void setCharacterPosition(int row,int col){
        this.characterPositionRow=row;
        this.characterPositionColumn=col;
    }

    public void startServers() {
    generateServer.start();
    solveServer.start();
    }

    public void stopServers() {
        generateServer.stop();
        solveServer.stop();
    }


    @Override
    public void solveMaze(){
        CommunicateWithServer_SolveSearchProblem();

    }

    @Override
    public void generateMaze(int rows, int cols) {
        this.solution=null;
        CommunicateWithServer_generateMaze(rows,cols);
        setChanged();
        notifyObservers(false);

    }
    private void CommunicateWithServer_SolveSearchProblem() {
        try {
            Client client = new Client(InetAddress.getLocalHost(), 5401, new IClientStrategy() {
                public void clientStrategy(InputStream inFromServer, OutputStream outToServer) {
                    try {
                        ObjectOutputStream toServer = new ObjectOutputStream(outToServer);
                        ObjectInputStream fromServer = new ObjectInputStream(inFromServer);
                        toServer.flush();
                        toServer.writeObject(maze);
                        toServer.flush();
                        Solution solution1 = (Solution)fromServer.readObject();
                        setSolution(solution1);
                    } catch (Exception var10) {
                        var10.printStackTrace();
                    }

                }
            });
            client.communicateWithServer();
            System.out.println("my model SM");
        } catch (UnknownHostException var1) {
            var1.printStackTrace();
        }

    }
    public Solution getSolution(){
        return this.solution;
    }


    private void setSolution(Solution solution){
        System.out.println("set solution");
        this.solution=solution;
    }




    private Maze CommunicateWithServer_generateMaze(int rows,int cols){
        try {
            Client client = new Client(InetAddress.getLocalHost(), 5400, new IClientStrategy() {
                @Override
                public void clientStrategy(InputStream inFromServer, OutputStream outToServer) {
                    try {
                        ObjectOutputStream toServer = new ObjectOutputStream(outToServer);
                        ObjectInputStream fromServer = new ObjectInputStream(inFromServer);
                        toServer.flush();
                        int[] mazeDimensions = new int[]{rows, cols};
                        toServer.writeObject(mazeDimensions);
                        toServer.flush();
                        byte[] compressedMaze = (byte[])fromServer.readObject();
                        InputStream is = new MyDecompressorInputStream(new ByteArrayInputStream(compressedMaze));
                        byte[] decompressedMaze = new byte[(rows*cols+24)];//not shore size
                        is.read(decompressedMaze);
                        maze =new Maze(decompressedMaze);
                        setMaze(maze);
                     //   setSolution(solution);


//                        characterPositionColumn = maze.getStartPosition().getColumnIndex();
//                        characterPositionRow=maze.getStartPosition().getRowIndex() ;
                        setCharacterPosition(maze.getStartPosition().getRowIndex(),maze.getStartPosition().getColumnIndex());
                        toServer.close();
                        fromServer.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
            client.communicateWithServer();
        } catch (UnknownHostException var1) {
            var1.printStackTrace();
        }
        return maze;
    }

    public void setMaze(Maze maze){
        this.maze=maze;
    }
    @Override
    public Maze getMaze() {
        return maze;
    }

    public boolean isLegalMove(int row,int col){
//        int height = Integer.valueOf(txtfld_rowsNum.getText());
//        int width = Integer.valueOf(txtfld_columnsNum.getText());
        if((maze!=null)&&((row>=0 && row<maze.getRow()) && (col>=0 && col<maze.getCol()))&& (maze.getCellValue(col,row)==0)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void  assignObserver(Observer o){
        this.addObserver(o);
    }

    @Override
    public void moveCharacter(KeyCode movement) {
        switch (movement) {
            case NUMPAD8://up
                if(isLegalMove(characterPositionRow-1,characterPositionColumn))
                characterPositionRow--;
                break;
            case NUMPAD2://down
                if(isLegalMove(characterPositionRow+1,characterPositionColumn))
                characterPositionRow++;
                break;
            case NUMPAD4://left
                if(isLegalMove(characterPositionRow,characterPositionColumn-1))
                characterPositionColumn--;
                break;
            case NUMPAD6://right
                if(isLegalMove(characterPositionRow,characterPositionColumn+1))
                    characterPositionColumn++;
                break;


            case NUMPAD7://left up
                if(isLegalMove(characterPositionRow-1,characterPositionColumn-1)){
                    characterPositionRow--;
                    characterPositionColumn--;
                }

                break;
            case NUMPAD9://right Up
                if(isLegalMove(characterPositionRow-1,characterPositionColumn+1))
                {
                    characterPositionRow--;
                    characterPositionColumn++;
                }
                break;
            case NUMPAD1://left down
                if(isLegalMove(characterPositionRow+1,characterPositionColumn-1)){
                    characterPositionRow++;
                    characterPositionColumn--;
                }

                break;
            case NUMPAD3://right down
                if(isLegalMove(characterPositionRow+1,characterPositionColumn+1)){
                    characterPositionRow++;
                    characterPositionColumn++;
                }

                break;


        }
        setChanged();
        notifyObservers();
    }
    @Override
    public  void  exitGame(){
        stopServers();
        System.exit(0);
    }

    @Override
    public void saveGame(File path) {
        Object[] detailsToSave = {this.maze,new Position(characterPositionRow,characterPositionColumn),this.solution};
        try {
            try
                (ObjectOutputStream myObjectOutputStream = new ObjectOutputStream(new FileOutputStream(path.getPath()+".maze"))){
                    myObjectOutputStream.writeObject(detailsToSave);
                }
            }
        catch (Exception e){
            e.printStackTrace();
        }
        }

    @Override
    public void Load(File path) {
        if(path==null){
            return;
        }
        else {
            Object [] propertiesToLoad=null;
            try {
                try(ObjectInputStream myObjectInputStream = new ObjectInputStream(new FileInputStream(path))){
                    propertiesToLoad = (Object[]) myObjectInputStream.readObject();
                    if(propertiesToLoad[2]==null){
                        solution=null;
                    }
                    else {
                        this.solution=(Solution)propertiesToLoad[2];
                    }
                    Position loadPos = (Position) propertiesToLoad[1];
                    this.characterPositionRow = loadPos.getRowIndex();
                    this.characterPositionColumn = loadPos.getColumnIndex();
                    Maze loadMaze = (Maze)propertiesToLoad[0];
                    this.maze=loadMaze;
                }
                setChanged();
                notifyObservers(false);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public MediaPlayer mediaPlayer;


    public Media gameSong;



}
