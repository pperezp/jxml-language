Proyecto para crear packs de lenguajes para tus aplicaciones java: Este proyecto se encarga de ayudarte a crear packs de idiomas para tus aplicaciones Java SE. Esta construido con netbeans y jdk 7. El archivo xml de idioma tiene que ser de la siguiente forma
# ¿Qué formato debe tener el archivo XML que guarde el idioma? #
```

<?xml version="1.0" encoding="UTF-8"?>
<language name="ingles">
<component id="nombre">name

Unknown end tag for &lt;/component&gt;


<component id="apellido">second name

Unknown end tag for &lt;/component&gt;


<component id="telefono">phone number

Unknown end tag for &lt;/component&gt;




Unknown end tag for &lt;/language&gt;


```

# DTD del archivo XML #
El archivo DTD de ese xml es el siguiente:

```

<?xml version='1.0' encoding='UTF-8'?>
<!ELEMENT language (component)+>
<!ATTLIST language name CDATA #IMPLIED>
<!ELEMENT component (#PCDATA)>
<!ATTLIST component id ID #REQUIRED>
```

Ambos archivos se encuentran en el proyecto, en la carpeta \languages

# Ejemplo básico #
Suponiendo que el archivo xml se llama ingles.xml y esta en la raiz de tu proyecto, el modo de uso sería el siguiente:

**1.- Importar las librerias jespxml.jar y jxmlLanguage.jar a tu proyecto netbeans**2.- La forma de utilizar es la siguiente:

```

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jxmllanguage.Language;
import org.jxmllanguage.exceptions.MalformedXMLLanguegeException;
import org.jxmllanguage.exceptions.ValueNotFoundException;

public class Main{

public static void main(String[] args) {
try {
Language lan = new Language("ingles.xml");
System.out.println(lan.getValueById("nombre"));
//en este caso mostrará "name"
} catch (ValueNotFoundException ex) {
Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
} catch (IOException | MalformedXMLLanguegeException ex) {
Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
}
}
}
```