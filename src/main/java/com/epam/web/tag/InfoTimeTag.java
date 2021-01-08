package com.epam.web.tag;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class InfoTimeTag extends TagSupport {
    private static final Logger LOGGER = LogManager.getLogger(InfoTimeTag.class);
    private static final String TAG_HORIZONTAL_LINE_OPEN = "<hr>";
    private static final String TAG_HORIZONTAL_LINE_CLOSE = "<hr/>";
    private static final String TAG_BOLD_OPEN = "<b> ";
    private static final String TAG_BOLD_CLOSE = " <b/>";

    @Override
    public int doStartTag() throws JspException {
        GregorianCalendar gc = new GregorianCalendar();
        String time = TAG_HORIZONTAL_LINE_OPEN + TAG_BOLD_OPEN + gc.getTime() + TAG_BOLD_CLOSE + TAG_HORIZONTAL_LINE_CLOSE;
        try {
            JspWriter out = pageContext.getOut();
            out.write(time);
        } catch (IOException e) {
            LOGGER.error("IOException in infoTimeTag!");
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() {
        return EVAL_PAGE;
    }
}
