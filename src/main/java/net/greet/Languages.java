package net.greet;

//import org.intellij.lang.annotations.Language;

//import static javafx.scene.input.KeyCode.G;

public enum Languages {

    english ("hello"),
    isixhosa ("molo"),
    tswana("dumela"),
    afrikaans("geomore");

    private  final String greets;

    Languages( String greets ) {
        this.greets = greets;
    }

    public String getGreets( String userName ){
        return greets + userName;
    }

    public String getGreets( ) {
        return greets;
    }
}
