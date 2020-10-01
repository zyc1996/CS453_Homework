package cs453.homework.hw5;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NameList {
    private static NameList sNameList;
    private List<Name> mNames;

    public static NameList get(Context context){
        if(sNameList == null){
            sNameList = new NameList(context);
        }
        return sNameList;
    }

    private NameList(Context context){
        mNames = new ArrayList<>();
        Name name = new Name();
        name.setmName("A Name");
        mNames.add(name);
    }

    public List<Name> getNames() {return mNames;}

    public Name getName(UUID id){
        for(Name name: mNames){
            if(name.getmID().equals(id)){
                return name;
            }
        }

        return null;
    }

    public void addName(String n){
        Name name = new Name();
        name.setmName(n);
        mNames.add(name);
    }

}
