
//*********************************************************************************************************************************************************************************************************************
// CoinDriver.java 
//
// Koki Yamanaka (T00681865)
// COMP 1231 Assignment 2 Porlymorphism - part 2
// this program is to demonstrate the behaviours of Lockable objects using and Lockable and Coin classes. 
//**********************************************************************************************************************************************************************************************************************
 

public class CoinDriver{

    // declare main method 
    public static void main( String[] args){
        Coin myObj = new Coin(); 
        myObj.flip();
        System.out.println(myObj);
        if (myObj.isHeads()){
            System.out.println("you won");
        }
        else {
            System.out.println("you lost");
        }
    }

}// end line of code - for CoinDriver class

