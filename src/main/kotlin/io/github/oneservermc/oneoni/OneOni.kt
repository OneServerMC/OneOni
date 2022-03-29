package io.github.oneservermc.oneoni

class OneOni : AbstractOneOni()
{
    companion object
    {
        lateinit var plugin: OneOni
    }

    override fun onEnable()
    {
        plugin = this
    }
}