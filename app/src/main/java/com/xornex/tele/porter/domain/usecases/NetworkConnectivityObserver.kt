package com.xornex.tele.porter.domain.usecases

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

class NetworkConnectivityObserver(context: Context) : ConnectivityObserver {
    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private val statusChannel = Channel<ConnectivityObserver.Status>()


    override fun observe(): Flow<ConnectivityObserver.Status> = statusChannel.receiveAsFlow()

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            statusChannel.trySend(ConnectivityObserver.Status.Available)
        }

        override fun onUnavailable() {
            statusChannel.trySend(ConnectivityObserver.Status.Unavailable)
        }

        override fun onLost(network: Network) {
            statusChannel.trySend(ConnectivityObserver.Status.Lost)
        }


        override fun onLosing(network: Network, maxMsToLive: Int) {
            statusChannel.trySend(ConnectivityObserver.Status.Losing)
        }
    }

    init {
        val request = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()

        connectivityManager.registerNetworkCallback(request, networkCallback)
    }

}