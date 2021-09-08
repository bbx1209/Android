package com.helloworld.Sections.downloads;

public interface DownloadListener {

    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPause();

    void onCancel();
}
