/*
 * NAME: Kevin Morales-Nguyen
 * PID: A17186624
 */

import java.io.*;
import java.util.*;

/**
 * This class implements a hashtable to
 * keep track of the frequency
 *
 * @author Kevin Morales-Nguyen
 * @since 11/22/21
 */
public class DocumentFrequency {

    private ArrayList<HashTable> word_tables = new ArrayList<HashTable>();
    private int num_documents;

    /**
     * This is the constructor for the Document frequency object
     * @param path
     * @throws IOException
     */
    public DocumentFrequency(String path) throws IOException {
        File file = new File(path); // open fail with path
        Scanner scanner = new Scanner(file); // create scanner on file
        while(scanner.hasNextLine()){ // go through everyline
            String line = scanner.nextLine();
            String[] tokens = line.split(" "); //get tokens

            HashTable word_table = new HashTable();
            for(int i = 0;i < tokens.length;i++){ // add tokens to hash table
                word_table.insert(tokens[i].toLowerCase());
            }

            word_tables.add(word_table); // add hash table to arraylist

            num_documents++;
        }


    }

    /**
     * This method returns the number of documents
     * @return int representing number of documents
     */
    public int numDocuments() {
        return this.num_documents;
    }

    /**
     * This method returns the frequency of a word from all documents
     * @param word the word to search for
     * @return the frequecy of word argument
     */
    public int query(String word) {
        int counter = 0;
        for(int i = 0; i < word_tables.size();i++){ // go through entire arraylist
            if(word_tables.get(i).lookup(word.toLowerCase())){ // search hash for word
                counter++;
            }
        }

        return counter;
    }

}
