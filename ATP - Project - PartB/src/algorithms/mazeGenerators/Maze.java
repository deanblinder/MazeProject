package algorithms.mazeGenerators;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Maze {

    Position startPosition = new Position(0,0);
    Position goalPosition= new Position(0,0);
    int row;
    int col;
    int [][] theMaze;

    /**
     * constructor of an empty maze
     * @param row number of rows
     * @param col number of columns
     */
    public Maze(int row, int col) {
        this.row = row;
        this.col = col;
        this.theMaze = new int[row][col];
        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                this.theMaze[i][j] = 0;
            }
        }

    }
    public  Maze(byte[] b){
        this.row = ByteBuffer.wrap(Arrays.copyOfRange(b,16,20)).getInt();
        this.col = ByteBuffer.wrap(Arrays.copyOfRange(b,20,24)).getInt();
        this.theMaze = new int[this.row][this.col];

        this.startPosition =new Position(ByteBuffer.wrap(Arrays.copyOfRange(b,0,4)).getInt(),ByteBuffer.wrap(Arrays.copyOfRange(b,4,8)).getInt());
        this.goalPosition =new Position(ByteBuffer.wrap(Arrays.copyOfRange(b,8,12)).getInt(),ByteBuffer.wrap(Arrays.copyOfRange(b,12,16)).getInt());


        int k=24;
        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                this.theMaze[i][j] =b[k];
                k++;
            }
        }

    }


    public  void insertToArray(byte[] insertTo,byte[] toInsert,int start){
        int j=0;
        for(int i=start;i<start+4;i++){
            insertTo[i]=toInsert[j];
            j++;
        }
    }

    public byte[] convertToBinary(int num){
        byte[] arr = new byte[4];
        int x=0, i=3;
        while (num!=0){
            x = num%2;
            arr[i] = (byte) x;
            num=num/2;
            i--;
        }
        return  arr;

    }
    public byte[]  toByteArray(){

        byte[] mazeInfo = new byte[this.getRow()*this.getCol()+6*4];
       // byte[] temp =convertToBinary( 6 );
        byte[] xIn =convertToBinary( this.getStartPosition().getRowIndex() );
       byte[] yIn = convertToBinary(this.getStartPosition().getColumnIndex());
        byte[] xOut = convertToBinary(this.getGoalPosition().getRowIndex());
        byte[] yOut =  convertToBinary(this.getGoalPosition().getColumnIndex());
        byte[] rows =  convertToBinary(this.getRow());
        byte[] cols =  convertToBinary(this.getCol());


        // byte[] xIn = ByteBuffer.allocate(4).putInt(this.getStartPosition().getRowIndex()).array();

       //byte[] yIn = ByteBuffer.allocate(4).putInt(this.getStartPosition().getColumnIndex()).array();
//
//        byte[] xOut = ByteBuffer.allocate(4).putInt(this.getGoalPosition().getRowIndex()).array();
//
//        byte[] yOut = ByteBuffer.allocate(4).putInt(this.getGoalPosition().getRowIndex()).array();
//
//        byte[] rows = ByteBuffer.allocate(4).putInt(this.getRow()).array();
//
//        byte[] cols = ByteBuffer.allocate(4).putInt(this.getCol()).array();

        insertToArray(mazeInfo,xIn,0);
        insertToArray(mazeInfo,yIn,4);
        insertToArray(mazeInfo,xOut,8);
        insertToArray(mazeInfo,yOut,12);
        insertToArray(mazeInfo,rows,16);
        insertToArray(mazeInfo,cols,20);


        int i=24;
        for (int j=0;j<getRow();j++){
            for (int k=0;k<getCol();k++){
                mazeInfo[i]=(byte) this.getCellValue(j,k);
                i++;
            }
        }
        return  mazeInfo;

    }
    /**
     *
     * @return start Position
     */
    public Position getStartPosition() {

        return startPosition;
    }

    /**
     *
     * @return goal Position
     */
    public Position getGoalPosition() {
        return goalPosition;
    }

    /**
     *
     * @param r row number
     * @param c col number
     * @param val value of goal position
     */
    public void setGoalPosition(int r, int c, int val) {
        this.goalPosition.setRow(r);
        this.goalPosition.setCol(c);
        this.theMaze[r][c]=val;
    }

    /**
     *
     * @return random start position
     */
    public Position chooseStartPosition(){
        final Random random = new Random();
        int c = random.nextInt(col-1)+1;
        int r = random.nextInt(row-1)+1;
        startPosition.setCol(c);
        startPosition.setRow(r);
        //setCellValue(startPosition.getCol(),startPosition.getRow(),8);

        return startPosition;
    }

    /**
     *
     * @return random goal position
     */
    public  Position chooseGoalPosition(){
        final Random random = new Random();
        int c = random.nextInt(col-1)+1;
        int r = random.nextInt(row-1)+1;
        goalPosition.setCol(c);
        goalPosition.setRow(r);
        return goalPosition;
    }

    /**
     *
     * @param row row number
     * @param col col number
     * @param value value of maze[row][col]
     */
    public void setCellValue(int row,int col,int value) {
        this.theMaze[row][col]=value;

    }

    /**
     *
     * @param row row number
     * @param col col number
     * @return the value of maze[row][col]
     */
    public int getCellValue(int row,int col) {
        if(row<this.row && col<this.col && col>=0 && row>=0){
            return theMaze[row][col];
        }
        return -1;
    }

    /**
     *
     * @return the number of rows
     */
    public int getRow() {
        return row;
    }

    /**
     *
     * @return the number of columns
     */
    public int getCol() {
        return col;
    }

    /**
     *
     * @return the maze
     */
    public int[][] getTheMaze() {
        return theMaze;
    }

    /**
     * print the maze;
     */



    public void print(){

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++) {
                Position p = new Position(i, j);
                if (p.equals(getStartPosition())) {
                    System.out.print("S");
                }
               else if (p.equals(getGoalPosition())) {
                    System.out.print("E");
                } else {
                    System.out.print(getCellValue(i, j) +"");
                }
            }
            System.out.println();
        }
    }

}

