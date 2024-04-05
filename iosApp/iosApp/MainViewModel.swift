//
//  MainViewModel.swift
//  iosApp
//
//  Created by Divya on 05/04/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

@MainActor
class MainViewModel: ObservableObject{
    
    @Published var catsFacts = [String]()
    
    let repository: CatsRepository = CatsRepositoryImpl()
    
    init(){
        Task {
            catsFacts = try! await repository.getCatsFacts().map{
                $0.mapToUiState().catFact
            }
        }
    }
    
}


