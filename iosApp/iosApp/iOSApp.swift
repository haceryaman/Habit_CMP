import ComposeApp
import SwiftUI

@main
struct iOSApp: App {
    init() {
        AppModuleKt.doInitKoin()
    }
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
