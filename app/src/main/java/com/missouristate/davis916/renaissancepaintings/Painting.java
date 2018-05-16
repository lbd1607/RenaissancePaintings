package com.missouristate.davis916.renaissancepaintings;

/**
 * Laura Davis CIS 262-902
 * 16 February 2018
 * The Painting class provides
 * a data model for a single painting.
 */

public class Painting {

    //Declare variables
    private String mDescription;
    private int mId;

    public Painting(String description, int id){
        mDescription = description;
        mId = id;
    }//end Painting constructor

    public String getDescription(){
        return mDescription;
    }

    public void setDescription(String description){
        mDescription = description;
    }

    public int getId(){
        return mId;
    }

    public void setId(int id){
        mId = id;
    }

}//end Painting class
