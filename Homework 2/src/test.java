import java.io.*;

class FileData
{
/** Class: FileData
 *  Contains the content of a record found in the input file. Each 
 *  FileData object contains exactly one record. An object of this
 *  type will be returned by readNextRecord(..) function on successful
 *  read. 
 *  Fields:
 *  id : ID of the record
 *  title : contains the title of the paper
 *  author: contains the author of the paper
 *  keywords is an array of all keywords related to that paper.
 */ 
	int id;
	String title;
	String author;
	String keywords[];

	/* Constructor */
	FileData(int id, String title, String author, int keywordCount)
	{
		this.id=id;
		this.title=title;
		this.author=author;
		keywords=new String[keywordCount];
		for(int i=0;i<keywords.length; i++)
		{
			keywords[i]=null;
		}
	} 

	/* Returns true if the keyword was successfully added 
	 * Keyword addition might fail if it does not meet the 
	 * original limit. This method adds a single keyword to the
         * keywords array in the end. This method will be invoked
         * by the getNextRecord() function at the time of building 
         * an object of this type
         */
	boolean addKeyword(String keyword)
	{
		for(int i=0;i<keywords.length;i++)
		{
			if(keywords[i]==null)
			{
				keywords[i]=keyword;
				return true;
			}
		}
		return false;
	}

}

class test
{
    BufferedReader b;
    bst a;

	/* Returns the next data record (a whole record object)
	 * in the data input file. Returns null if there
	 * is not such record. Hence a null indicates end of file or some error
	 * Error message will be displayed on the screen.
	 * DO NOT CHANGE THIS FUNCTION!
         */
	public FileData readNextRecord()
	{
		if(b == null)
		{
			System.out.println("Error: You must open the file first.");
			return null;
		}
		else
		{
			FileData readData;
			try
			{
				String data=b.readLine();
				if(data==null)
					return null;
				int readNo = Integer.parseInt(data);
				readData= new FileData(readNo,b.readLine(),
					b.readLine(),Integer.parseInt(b.readLine()));		
				for(int i=0;i<readData.keywords.length;i++)
				{
					readData.addKeyword(b.readLine());
				}
				String space=b.readLine();
				if((space!=null)&&(!space.trim().equals("")))
				{
					System.out.println("Error in file format");
					return null;
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("Error Number Expected! ");
				return null;
			}
			catch(Exception e)
			{
				System.out.println("Fatal Error: "+e);
				return null;
			}	
			return readData;
		}
	}

    public test(String filename)
    {
       try
       {
           this.a = new bst();
           this.b = new BufferedReader(new FileReader(filename));
            
           /* READS DATAFILE.TXT INTO DATASTRUCTURE  */
           
           FileData fd;
           while ((fd = this.readNextRecord()) != null)
           {
               for (int i=0; i<fd.keywords.length; i++)
               {
                   a.insert(fd.keywords[i], fd);
               }
           }
        } 
       catch (IOException e) 
       	{
           e.printStackTrace();
        } 
       finally 
       {
            try 
            {
                if (b!=null) 
                	b.close();
            } 
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args)
    {
            test T = new test("datafile.txt"); // THIS WILL CREATE YOUR BST AND FILL IT WITH THE INFORMATION FROM THE DATAFILE
            
            /* This line of code should return the first record in the linked list for a given keyword.
             * It may be useful for your personal debugging
             */ 
            
            //T.a.get_records("medical" /*Insert keyword to be found here. "medical" is an example*/).print();

            
            T.a.print(); // Prints titles of all elements in the bst sorted by keyword.
            System.out.println("---------------------------------------------------------");
            System.out.println("Size of the list at the root of the tree (" + T.a.root.keyword + ") is - " + T.a.root.getSize());

            System.out.println("---------------------------------------------------------");
            System.out.println("Checking contains for medical before deletion - " + T.a.contains("medical"));
            
            T.a.delete("medical");
            T.a.delete("learning");
            T.a.delete("concepts");
            
            System.out.println();
            System.out.println("Checking contains for medical after deletion - " + T.a.contains("medical"));
            
            System.out.println("---------------------------------------------------------");
            System.out.println("After deletion - ");
            System.out.println();
            
            T.a.print(); //Prints bst after the 3 deletions
            
            System.out.println("---------------------------------------------------------");
            System.out.println("Checking the word sptaial in get records results in - ");
            T.a.get_records("spatial").print();
            System.out.println();
            System.out.println("Checking the word testing in get records results in - ");
            if(T.a.get_records("testing") == null)
            {
            	System.out.println("The word testing was not found");
            }

            System.out.println("---------------------------------------------------------");
            System.out.println("Deleting the rest of the keywords and recalling print - ");
            System.out.println();
            
//            //Deleting the rest of the keywords.
//            T.a.delete("blobs");
//            T.a.delete("buildings");
//            T.a.delete("causal-relationships");
//            T.a.delete("classification-rules");
//            T.a.delete("clustering");
//            T.a.delete("content-based");
//            T.a.delete("data-mining");
//            T.a.delete("database");
//            T.a.delete("distance-measures");
//            T.a.delete("image-display");
//            T.a.delete("image-management");
//            T.a.delete("image-retrieval");
//            T.a.delete("image-stack");
//            T.a.delete("indexing");
//            T.a.delete("information-retrieval");
            
//            //Seems to be something weird here, when I remove the whitespace in second deletion it works,
//            //when I leave the whitespace there it leaves a few undeleted.
//            T.a.delete("instance-based");
//
//            T.a.delete("knowledge");
//            T.a.delete("lines");
//            T.a.delete("matching");
//            
//            //Seems to be something weird here, this won't work unless I call multimedia twice.
//            T.a.delete("multimedia");
//            T.a.delete("multimedia");
//            
//            T.a.delete("neural-networks");
//            T.a.delete("pose");
//            T.a.delete("pruning");
//            T.a.delete("queries");
//            T.a.delete("query-by-example");
//            T.a.delete("query-trees");
//            T.a.delete("recognition");
//            T.a.delete("region-based");
//            T.a.delete("relational");
//            T.a.delete("search");
//            T.a.delete("similarity");
//            T.a.delete("spatial");
//            T.a.delete("temporal");
//            T.a.delete("time-related");
//            T.a.delete("triangle-inequality");
//            T.a.delete("weighting");
            
            //Reprinting after deleting all of the keywords.
            T.a.clearTree();
            T.a.print();
            
            //T.a.delete("weighting");
            
            // THIS AREA IS FOR YOUR USE TO HELP TEST THAT YOUR BST WORKS
    }
}
