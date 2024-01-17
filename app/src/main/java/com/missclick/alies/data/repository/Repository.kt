package com.missclick.alies.data.repository


import com.missclick.alies.data.models.Team
import com.missclick.alies.data.repository.dictionary.LocalDictionaries
import com.missclick.alies.data.repository.team.LocalTeams

class Repository(private val localDictionaries: LocalDictionaries, private val localTeams: LocalTeams) : IRepository {

    override fun getAllTeams(): List<Team> {
        return localTeams.getAll()
    }

    override fun getDictionariesNames(): List<String> {
       return localDictionaries.getNames()
    }

    override fun getWordsByDictionariesName(names: List<String>): List<String> {
        return localDictionaries.getWordsByNames(names)
    }

}