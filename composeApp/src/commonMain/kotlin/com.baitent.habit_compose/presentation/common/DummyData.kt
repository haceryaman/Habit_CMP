package com.baitent.habit_compose.presentation.features.common

import com.baitent.habit_compose.presentation.features.common.views.custom.CustomDropDownButtonData
import com.baitent.habit_compose.presentation.common.views.items.MissionItemData


class DummyData {
    companion object {
        fun getHabits():List<MissionItemData>{
                return listOf(
                    MissionItemData(id = "a1",title = "Egzersiz yap", isChecked = true),
                    MissionItemData(id = "a2",title = "Kitap oku", isChecked = false),
                    MissionItemData(id = "a3",title = "Gökhan abinin videoları izle", isChecked = true),
                    MissionItemData(id = "a4",title = "Meditasyon yap", isChecked = true),
                )
        }

        fun getPeriods():List<CustomDropDownButtonData> =  listOf(
            CustomDropDownButtonData(0,"1 Week"),
            CustomDropDownButtonData(1,"1 Moonth")
        )
    }
}