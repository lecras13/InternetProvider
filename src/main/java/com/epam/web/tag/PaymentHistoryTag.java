package com.epam.web.tag;

import com.epam.web.entity.Payment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

public class PaymentHistoryTag extends TagSupport {
    private static final Logger LOGGER = LogManager.getLogger(PaymentHistoryTag.class);
    private static final String PAYMENTS = "payments";
    private static final String TAG_ROW_OPEN = "<tr>";
    private static final String TAG_ROW_CLOSE = "</tr>";
    private static final String TAG_COLUMN_OPEN = "<td>";
    private static final String TAG_COLUMN_CLOSE = "</td>";

    @Override
    public int doStartTag() {
        ServletRequest servletRequest = pageContext.getRequest();
        List<Payment> paymentList = (List<Payment>) servletRequest.getAttribute(PAYMENTS);
        int index = 0;
        while (index < paymentList.size()) {
            Payment payment = paymentList.get(index);
            try {
                pageContext.getOut().write(TAG_ROW_OPEN + TAG_COLUMN_OPEN + payment.getPaymentDate() + TAG_COLUMN_CLOSE +
                        TAG_COLUMN_OPEN + payment.getAmount() + TAG_COLUMN_CLOSE + TAG_ROW_CLOSE);
            } catch (IOException e) {
                LOGGER.error("Error while write out");
            }
            index++;
        }
        return SKIP_BODY;
    }
}

