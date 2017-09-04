package com.emedinaa.infosoft2017.model

import java.io.Serializable

/**
 * Created by emedinaa on 2/09/17.
 */
class EntityK {

    enum class ItemType {
        HEADER, SPONSOR
    }

    enum class EventType {
        HEADER, EVENT
    }

    data class SpeakerK(val title:String,val country:String, val image:String,
                        val bio:String, val name:String): Serializable

    data class SponsorK(val title:String, val image:String,val type:ItemType):Serializable

    data class EventK(val day:String,val time:String, val activity:String,val type:EventType):Serializable
}