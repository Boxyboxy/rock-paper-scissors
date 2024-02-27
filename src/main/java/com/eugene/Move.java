package main.java.com.eugene;

public enum Move {

        ROCK("rock"),
        PAPER("paper"),
        SCISSORS("scissors");
        public String value;
        Move(String value){
            this.value = value;
        }
        public String getValue(){
            return value;
        }


}
