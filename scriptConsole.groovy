import jenkins.model.Jenkins
import hudson.model.*
import hudson.security.*

def pluginNames = [
    "authorize-project",
]

def jenkinsInstance = Jenkins.getInstance()

pluginNames.each { pluginName ->
    def jobsUsingPlugin = []
    def allItems = jenkinsInstance.getAllItems(AbstractItem.class)

    allItems.each { item ->
        def itemConfig = item.getConfigFile().getFile()

        if (itemConfig != null && itemConfig.exists()) {
            def configXml = itemConfig.text

            if (configXml.contains(pluginName)) {
                jobsUsingPlugin.add("${jenkinsInstance.getRootUrl()}${item.getUrl()}")
            }
        }
    }

    println "${jobsUsingPlugin.size()} adet job'da kullanılıyor. ${jobsUsingPlugin.size() > 0 ? 'Örnek Job URL: ' + jobsUsingPlugin[0] : ''}"

}
