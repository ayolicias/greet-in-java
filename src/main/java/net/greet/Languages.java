package net.greet;

import org.intellij.lang.annotations.Language;

//import static javafx.scene.input.KeyCode.G;

public enum Languages {

    ENGLISH ("Hello "),
    ISIXHOSA ("Molo "),
    AFRIKAANS("Geomore "),
    ;

//    public void greet(){
//        this.greet();
//    }

    private  final String greets;

    Languages( String greets ) {
        this.greets= greets;
    }


    public String getGreets( String userName ){

        return greets + userName;
    }

}
