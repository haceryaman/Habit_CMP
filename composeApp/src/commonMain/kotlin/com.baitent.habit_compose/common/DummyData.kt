package com.baitent.habit_compose.common

import com.baitent.habit_compose.presentation.common.views.custom.CustomDropDownButtonData
import com.baitent.habit_compose.presentation.common.views.items.HabitItemData


class DummyData {
    companion object {
        fun getHabits():List<HabitItemData>{
                return listOf(
                    HabitItemData(id = "a1",title = "Egzersiz yap", isChecked = true),
                    HabitItemData(id = "a2",title = "Kitap oku", isChecked = false),
                    HabitItemData(id = "a3",title = "Gökhan abinin videoları izle", isChecked = true),
                    HabitItemData(id = "a4",title = "Meditasyon yap", isChecked = true),
                )
        }

        fun getPeriods():List<CustomDropDownButtonData> =  listOf(
            CustomDropDownButtonData(0,"1 Week"),
            CustomDropDownButtonData(1,"1 Moonth")
        )
    }
}