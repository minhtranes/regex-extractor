package vn.sps.ias.domain;

public class Request {
    private String id;

    private String text;

    private String extractionRule;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getExtractionRule() {
        return extractionRule;
    }

    public void setExtractionRule(String extractionRule) {
        this.extractionRule = extractionRule;
    }
}
