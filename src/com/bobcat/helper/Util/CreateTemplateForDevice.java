package com.bobcat.helper.Util;


import com.amazon.ask.model.interfaces.display.*;


import java.util.ArrayList;
import java.util.List;

public class CreateTemplateForDevice {

    /**
     * Helper method to create the a body template for the launch request
     * @param  primaryText
     * @param  secondaryText
     * @param imageURL
     * @return Template
     */
    public Template templateTitle(String primaryText, String secondaryText, String imageURL){
        return BodyTemplate6.builder()
                .withBackgroundImage(getImage(imageURL))
                .withTextContent(getTextContent(primaryText,secondaryText))
                .build();
    }

    /**
     * Helper method to create a template 1 for the some request
     * @param
     */
    public Template template1(String titile,String primaryText, String secondaryText, String imgUrl){
        return BodyTemplate1.builder()
                .withBackgroundImage(getImage(imgUrl))
                .withTextContent(getTextContent(primaryText,secondaryText))
                .withTitle(titile)
                .build();
    }

    /**
     * Helper method to create the a body template for the other intent request
     * @param  primaryText
     * @param  secondaryText
     * @param imageURL
     * @param  bgImageURL
     * @return Template
     */
    public Template normalTemplate(String tmpTitle, String primaryText, String secondaryText, String imageURL,String bgImageURL){
        return BodyTemplate3.builder()
                .withImage(getImage(imageURL))
                .withBackgroundImage(getImage(bgImageURL))
                .withTitle(tmpTitle)
                .withTextContent(getTextContent(primaryText,secondaryText))
                .build();
    }

    /**
     * Helper method to create the a body template for the other intent request
     * @param imageURL
     * @param  bgImageURL
     * @return Template
     */

    public Template instructionStartTemplate(String tmpTitle,String imageURL,String bgImageURL){
        return BodyTemplate7.builder()
                .withImage(getImage(imageURL))
                .withBackgroundImage(getImage(bgImageURL))
                .withTitle(tmpTitle)
                .build();
    }
    /**
     * Helper method to create the image object for display interfaces
     * @param : imageIRl for the image
     * @return : Image that is used in a boy template
     */
    private Image getImage( String imageURL){
        List<ImageInstance> instances = getImageInstance(imageURL);
        return Image.builder().withSources(instances).build();
    }

    /**
     * Helper method to create Lis tof image instances
     * @param imageURl the url on the image
     * @return instaces that is used in the image object
     */

    private List<ImageInstance> getImageInstance(String imageURl){
        List<ImageInstance> instances = new ArrayList<>();
        ImageInstance instance = ImageInstance.builder().withUrl(imageURl).build();
        instances.add(instance);
        return  instances;
    }

    /**
     * Helper method that returns text content to be use in the body tempalte
     * @param primariyText
     * @param secondaryText
     * @return Text that will be rendered with the body template
     */
    private TextContent getTextContent(String primariyText, String secondaryText){
        return TextContent.builder()
                .withPrimaryText(makeRichText(primariyText))
                .withSecondaryText(makeRichText(secondaryText))
                .build();
    }

    /**
     * Helper method that returns the rich text that can be set as the text content for a body template.
     * @param text The string that needs to be set as the text content for the body template.
     * @return RichText that will be rendered with the body template
     */
    private RichText makeRichText(String text) {
        return RichText.builder()
                .withText(text)
                .build();
    }
}
