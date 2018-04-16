package com.txcsmad.mad.models

import com.google.gson.annotations.SerializedName
import com.txcsmad.mad.utils.TimeUtils
import java.util.*

data class Event(@SerializedName("title") val title: String,
                 @SerializedName("start_time") private val _start: String,
                 @SerializedName("end_time") private val _end: String,
                 @SerializedName("location") val location: String,
                 @SerializedName("description") val description: String,
                 @SerializedName("image_url") val imageUrl: String,
                 @SerializedName("event_tags") val tags: Array<Int>) {
    var startTime: String
        private set
    var endTime: String
        private set
    var startDate: String
        private set
    var endDate: String
        private set
    var timeSpan: String
        private set

    init {
        startTime = TimeUtils.getFormattedTime(_start)
        startDate = TimeUtils.getFormattedDate(_start)
        endTime = TimeUtils.getFormattedTime(_end)
        endDate = TimeUtils.getFormattedDate(_end)
        timeSpan = TimeUtils.getTimeSpan(startTime, endTime)
    }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Event

        if (title != other.title) return false
        if (_start != other._start) return false
        if (_end != other._end) return false
        if (location != other.location) return false
        if (description != other.description) return false
        if (imageUrl != other.imageUrl) return false
        if (!Arrays.equals(tags, other.tags)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + _start.hashCode()
        result = 31 * result + _end.hashCode()
        result = 31 * result + location.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + imageUrl.hashCode()
        result = 31 * result + Arrays.hashCode(tags)
        return result
    }


}