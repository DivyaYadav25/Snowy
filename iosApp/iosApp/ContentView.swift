import SwiftUI
import shared

struct ContentView: View {
	@StateObject var viewModel = MainViewModel()

	var body: some View {
        List{
           
            ForEach(viewModel.catsFacts, id: \.self) {
                Text($0)
            }
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
