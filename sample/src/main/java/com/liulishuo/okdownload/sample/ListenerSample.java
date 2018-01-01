/*
 * Copyright (c) 2017 LingoChamp Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liulishuo.okdownload.sample;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.liulishuo.okdownload.DownloadListener;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.SpeedCalculator;
import com.liulishuo.okdownload.core.breakpoint.BlockInfo;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import com.liulishuo.okdownload.core.listener.DownloadListener1;
import com.liulishuo.okdownload.core.listener.DownloadListener2;
import com.liulishuo.okdownload.core.listener.DownloadListener3;
import com.liulishuo.okdownload.core.listener.DownloadListener4;
import com.liulishuo.okdownload.core.listener.DownloadListener4WithSpeed;
import com.liulishuo.okdownload.core.listener.assist.Listener1Assist;
import com.liulishuo.okdownload.core.listener.assist.Listener4Assist;
import com.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend;

import java.util.List;
import java.util.Map;

public class ListenerSample {

    private static final String TAG = "ListenerSample";

    private static void log(String msg) {
        Log.d(TAG, msg);
    }

    public DownloadListener listener() {
        return new DownloadListener() {

            @Override public void taskStart(DownloadTask task) {
                log("taskStart");
            }

            @Override public void downloadFromBeginning(DownloadTask task, BreakpointInfo info,
                                                        ResumeFailedCause cause) {
                log("downloadFromBeginning");
            }

            @Override public void downloadFromBreakpoint(DownloadTask task, BreakpointInfo info) {
                log("downloadFromBreakpoint");
            }

            @Override public void connectStart(DownloadTask task, int blockIndex,
                                               @NonNull Map<String, List<String>> requestHeader) {
                log("connectStart");
            }

            @Override public void connectEnd(DownloadTask task, int blockIndex, int responseCode,
                                             @NonNull Map<String, List<String>> responseHeader) {
                log("connectEnd");
            }

            @Override public void splitBlockEnd(DownloadTask task, BreakpointInfo info) {
                log("splitBlockEnd");
            }

            @Override
            public void fetchStart(DownloadTask task, int blockIndex, long contentLength) {
                log("fetchStart");
            }

            @Override
            public void fetchProgress(DownloadTask task, int blockIndex, long increaseBytes) {
                log("fetchProgress");
            }

            @Override public void fetchEnd(DownloadTask task, int blockIndex, long contentLength) {
                log("fetchEnd");
            }

            @Override
            public void taskEnd(DownloadTask task, EndCause cause, @Nullable Exception realCause) {
                log("taskEnd");
            }
        };
    }

    public DownloadListener1 lisetner1() {
        return new DownloadListener1() {
            @Override
            public void taskStart(DownloadTask task,
                                  Listener1Assist.Listener1Model model) {
                log("taskStart");
            }

            @Override public void retry(DownloadTask task, @NonNull ResumeFailedCause cause) {
                log("retry");
            }

            @Override
            public void connected(DownloadTask task, int blockCount, long currentOffset,
                                  long totalLength) {
                log("connected");
            }

            @Override
            public void progress(DownloadTask task, long currentOffset, long totalLength) {
                log("progress");
            }

            @Override
            public void taskEnd(DownloadTask task, EndCause cause, @Nullable Exception realCause,
                                @NonNull Listener1Assist.Listener1Model model) {
                log("taskEnd");
            }
        };
    }

    public DownloadListener2 lisetner2() {
        return new DownloadListener2() {
            @Override public void taskStart(DownloadTask task) {
                log("taskStart");
            }

            @Override
            public void taskEnd(DownloadTask task, EndCause cause, @Nullable Exception realCause) {
                log("taskEnd");
            }
        };
    }

    public DownloadListener3 listener3() {
        return new DownloadListener3() {
            @Override protected void started(DownloadTask task) {
                log("started");
            }

            @Override public void retry(DownloadTask task, @NonNull ResumeFailedCause cause) {
                log("retry");
            }

            @Override
            public void connected(DownloadTask task, int blockCount, long currentOffset,
                                  long totalLength) {
                log("connected");
            }

            @Override
            public void progress(DownloadTask task, long currentOffset, long totalLength) {
                log("progress");
            }

            @Override protected void completed(DownloadTask task) {
                log("completed");
            }

            @Override protected void canceled(DownloadTask task) {
                log("canceled");
            }

            @Override protected void error(DownloadTask task, Exception e) {
                log("error");
            }

            @Override protected void warn(DownloadTask task) {
                log("warn");
            }
        };
    }

    public DownloadListener4 listener4() {
        return new DownloadListener4() {
            @Override public void taskStart(DownloadTask task) {
                log("taskStart");
            }

            @Override
            public void infoReady(DownloadTask task, @NonNull BreakpointInfo info,
                                  boolean fromBreakpoint,
                                  @NonNull Listener4Assist.Listener4Model model) {
                log("infoReady");
            }

            @Override public void connectStart(DownloadTask task, int blockIndex,
                                               @NonNull Map<String, List<String>> requestHeader) {
                log("connectStart");
            }

            @Override public void connectEnd(DownloadTask task, int blockIndex, int responseCode,
                                             @NonNull Map<String, List<String>> responseHeader) {
                log("connectEnd");
            }


            @Override
            public void progressBlock(DownloadTask task, int blockIndex, long currentBlockOffset) {
                log("progressBlock");
            }

            @Override public void progress(DownloadTask task, long currentOffset) {
                log("progress");
            }

            @Override public void blockEnd(DownloadTask task, int blockIndex, BlockInfo info) {
                log("blockEnd");
            }

            @Override
            public void taskEnd(DownloadTask task, EndCause cause, @Nullable Exception realCause,
                                @NonNull Listener4Assist.Listener4Model model) {
                log("taskEnd");
            }
        };
    }

    public DownloadListener4WithSpeed listener4WithSpeed() {
        return new DownloadListener4WithSpeed() {
            @Override public void taskStart(DownloadTask task) {
                log("taskStart");
            }

            @Override
            public void infoReady(DownloadTask task, @NonNull BreakpointInfo info,
                                  boolean fromBreakpoint,
                                  @NonNull Listener4SpeedAssistExtend.Listener4SpeedModel model) {
                log("infoReady");
            }

            @Override public void connectStart(DownloadTask task, int blockIndex,
                                               @NonNull Map<String, List<String>> requestHeader) {
                log("connectStart");
            }

            @Override public void connectEnd(DownloadTask task, int blockIndex, int responseCode,
                                             @NonNull Map<String, List<String>> responseHeader) {
                log("connectEnd");
            }

            @Override
            public void progressBlock(DownloadTask task, int blockIndex, long currentBlockOffset,
                                      @NonNull SpeedCalculator blockSpeed) {
                log("progressBlock");
            }

            @Override public void progress(DownloadTask task, long currentOffset,
                                           @NonNull SpeedCalculator taskSpeed) {
                log("progress");
            }

            @Override public void blockEnd(DownloadTask task, int blockIndex, BlockInfo info,
                                           @NonNull SpeedCalculator blockSpeed) {
                log("blockEnd");
            }

            @Override
            public void taskEnd(DownloadTask task, EndCause cause, @Nullable Exception realCause,
                                @NonNull SpeedCalculator taskSpeed) {
                log("taskEnd");
            }
        };
    }


}
