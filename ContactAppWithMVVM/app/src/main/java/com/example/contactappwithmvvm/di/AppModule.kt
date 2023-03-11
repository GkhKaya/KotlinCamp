package com.example.contactappwithmvvm.di

import android.provider.ContactsContract.Data
import com.example.contactappwithmvvm.data.repo.ContactsDaoRepository
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideContactsDaoRepository(refContact:DatabaseReference):ContactsDaoRepository{
        return  ContactsDaoRepository(refContact)
    }

    @Provides
    @Singleton
    fun provideContactsDaoReferance():DatabaseReference{
        val db = FirebaseDatabase.getInstance()
        return db.getReference("contacts")
    }
}