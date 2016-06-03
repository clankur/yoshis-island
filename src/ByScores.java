   import java.util.Comparator;

   /**
    * The Comparator class that is used to compare and sort scores in the application.
    */
    public class ByScores implements Comparator<scoreReader>
   {
       /**
        * The compare implementation
        * @param arg1
        * @param arg2
        * @return
        */
       public int compare(scoreReader arg1, scoreReader arg2)
      {
         return arg2.getScore() - arg1.getScore();
      }
   }