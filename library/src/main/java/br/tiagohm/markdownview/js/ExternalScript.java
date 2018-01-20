package br.tiagohm.markdownview.js;

public class ExternalScript implements JavaScript {
    private final String mSrc;
    private final boolean mIsAsync;
    private final boolean mIsDefer;
    private final String mType;

    public ExternalScript(String src, boolean isAsync, boolean isDefer, String type) {
        mSrc = src;
        mIsAsync = isAsync;
        mIsDefer = isDefer;
        mType = type;
    }

    public ExternalScript(String url, boolean isAsync, boolean isDefer) {
        this(url, isAsync, isDefer, "text/javascript");
    }

    public String getSrc() {
        return mSrc;
    }

    public String getType() {
        return mType;
    }

    public boolean isAsync() {
        return mIsAsync;
    }

    public boolean isDefer() {
        return mIsDefer;
    }

    @Override
    public String toHTML() {
        return String.format("<script %s%ssrc='%s' type='%s'></script>\n",
                isAsync() ? "async " : "",
                isDefer() ? "defer " : "",
                getSrc(),
                getType());
    }
}
