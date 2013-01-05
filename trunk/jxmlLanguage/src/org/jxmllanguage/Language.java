/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jxmllanguage;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.jespxml.JespXML;
import org.jespxml.modelo.Tag;
import org.jxmllanguage.exceptions.MalformedXMLLanguegeException;
import org.jxmllanguage.exceptions.ValueNotFoundException;
import org.jxmllanguage.model.Component;
import org.xml.sax.SAXException;

/**
 *
 * @author pato
 */
public class Language extends File{
    private String name;
    private List<Component> components;
    
    public Language(String pathname) throws IOException, MalformedXMLLanguegeException{
        super(pathname);
        init();
    }

    public Language(String parent, String child) throws IOException, MalformedXMLLanguegeException{
        super(parent, child);
        init();
    }

    public Language(File parent, String child) throws IOException, MalformedXMLLanguegeException{
        super(parent, child);
        init();
    }

    public Language(URI uri) throws IOException, MalformedXMLLanguegeException{
        super(uri);
        init();
    }
    
    @Override
    public String getName(){
        return this.name;
    }
    
    private void init() throws IOException, MalformedXMLLanguegeException{
        components = new ArrayList<>();
        loadXML();
    }
    
    private void loadXML() throws IOException, MalformedXMLLanguegeException{
        try {
            JespXML file = new JespXML(this);
            Tag root = file.leerXML();
            
            this.name = root.getValorDeAtributo("name");
            
            for(Tag component : root.getTagsHijos()){
                components.add(new Component(
                        component.getValorDeAtributo("id"),
                        component.getContenido().trim()
                        ));
            }
        } catch (ParserConfigurationException | SAXException ex) {
            throw new MalformedXMLLanguegeException(ex.getMessage());
        } catch (IOException ex) {
            throw new IOException(ex.getMessage());
        }
    }
    
    public String getValueById(final Object id) throws ValueNotFoundException{
        for(Component comp : this.components){
            if(comp.getId().equalsIgnoreCase(id.toString())){
                return comp.getValue();
            }
        }
        throw new ValueNotFoundException("Value not found by name \""+id+"\"");
    }
    
    public List<Component> getComponents(){
        return this.components;
    }
}
