/**
 * यह फ़ंक्शन यह जांचता है कि दिया गया टाइमस्टैम्प और एक्सपायर्ड थ्रेशोल्ड के आधार पर मेट्रिक को कैश से हटाया जाना चाहिए या नहीं।
 * 
 * @param timestamp        वर्तमान समय का टाइमस्टैम्प
 * @param expiredThreshold पिछले अपडेट समय और कैश से हटाए जाने वाले समय बिंदु के बीच की अवधि को दर्शाता है।
 * @return true का मतलब है कि इस मेट्रिक को कैश से हटाया जाना चाहिए।
 */
public boolean isExpired(long timestamp, long expiredThreshold) {
    long currentTime = System.currentTimeMillis();
    return (currentTime - timestamp) > expiredThreshold;
}