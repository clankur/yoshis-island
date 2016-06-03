	//Name___________________ Date_____________
    public class scoreReader 
   {
   	//data fields
      private String myName;
      private int myScore;
      public scoreReader(int score)
      {
         myScore=score;
      }
      public int getScore()
      {
         return myScore;
      }
      public void setScore(int score)
      {
         myScore=score;
      }
      //public String getName()
      //{
      //   return myName;
      //}
      public String toString()
      {
         String montoya=" \n score: "+getScore();
         return montoya;
      }
 }